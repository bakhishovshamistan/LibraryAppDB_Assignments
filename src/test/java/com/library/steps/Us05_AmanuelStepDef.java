package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;

public class Us05_AmanuelStepDef {

    String actualMostBorrowedBookGenre = "";

    @When("I execute query to find most popular book genre")
    public void i_execute_query_to_find_most_popular_book_genre() {

        String query = "SELECT bc.name, count(*) from book_borrow bb\n" +
                "       inner join books b on bb.book_id = b.id\n" +
                "       inner join book_categories bc on b.book_category_id = bc.id\n" +
                "group by name\n" +
                "order by 2 desc;";

        //run the query
         DB_Util.runQuery(query);

         //retrieving the first name of the query which is the most borrowed book genre
          actualMostBorrowedBookGenre = DB_Util.getFirstRowFirstColumn();
          


    }
    @Then("verify {string} is the most popular book genre.")
    public void verify_is_the_most_popular_book_genre(String bookGenre) {

        String expectedMostBorrowedBookGenre = bookGenre;


        Assert.assertEquals( "Assertion Check",expectedMostBorrowedBookGenre,actualMostBorrowedBookGenre);

    }

}
