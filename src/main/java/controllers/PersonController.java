package controllers;

import helpers.DBHelper;
import models.Person;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static spark.Spark.get;
import static spark.Spark.post;


public class PersonController {

    public static void main(String[] args) {

        Person person1 = new Person(LocalDate.now(), "Alex");
        DBHelper.save(person1);


        get ("/persons/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "templates/persons/create.vtl");
        }, new VelocityTemplateEngine());

        post ("/persons", (req, res) -> {
            String dobString = req.queryParams("dob");
            String name = req.queryParams("name");
            Person newPerson = new Person(LocalDate.parse(dobString), name);
            DBHelper.save(newPerson);
            res.redirect("/persons");
            return null;
        });

        get("/persons", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Person> persons = DBHelper.getAll(Person.class);
            model.put("persons", persons);
            return new ModelAndView(model, "templates/persons/index.vtl");
        }, new VelocityTemplateEngine());



    }




}
