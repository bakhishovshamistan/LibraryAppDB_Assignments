package com.library.steps;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class JiraUS02 {

String actualBorrowedBooksNumber;
DashBoardPage dashBoardPage=new DashBoardPage();
LoginPage loginPage=new LoginPage();
@Given("the {string} on the home page")
public void the_on_the_home_page(String user) {
loginPage.login(user);
BrowserUtil.waitFor(2);

}
@When("the librarian gets borrowed books number")
public void the_librarian_gets_borrowed_books_number() {
String query="select count(*) from book_borrow where is_returned=0";

DB_Util.runQuery(query);
actualBorrowedBooksNumber=DB_Util.getFirstRowFirstColumn();
System.out.println("actualBorrowedBooksNumber = " + actualBorrowedBooksNumber);
}
@Then("borrowed books number information must match with DB")
public void borrowed_books_number_information_must_match_with_db() {
BrowserUtil.waitFor(5);
String expectedBorrowedBooks=dashBoardPage.borrowedBooksNumber.getText();

Assert.assertEquals(expectedBorrowedBooks,actualBorrowedBooksNumber);
System.out.println("expectedBorrowedBooks = " + expectedBorrowedBooks);
System.out.println("actualBorrowedBooksNumber = " + actualBorrowedBooksNumber);
}



}
