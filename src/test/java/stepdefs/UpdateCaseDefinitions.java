package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;

public class UpdateCaseDefinitions {

    private RequestSpecification request;
    private Response response;

    private String nextAssignmentID;

    public UpdateCaseDefinitions(){
        RestAssured.baseURI = "https://lab0160.lab.pega.com:443/prweb/api/v1";

        request = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .auth().basic("demo@pega.com", "devops123!");
    }

    @Given("^A new update customer case type$")
    public void a_new_update_customer_case_type() throws Exception {
        JSONObject jsonObj = new JSONObject()
                .put("caseTypeID", "MyOrg-DemoApp-Work-UpdateCustomer")
                .put("processID", "pyStartCase");

        nextAssignmentID = request.body(jsonObj.toString())
                .when()
                        .post("/cases")
                .then()
                        .statusCode(201)
                        .extract()
                        .body()
                        .path("nextAssignmentID");
    }

    @When("^I look for a customer with ID \"([^\"]*)\"$")
    public void i_look_for_a_customer_with_ID(String arg1) throws Exception {
        JSONObject jsonObj = new JSONObject()
                .put("content", new JSONObject()
                        .put("SelectedCustomerID", arg1));

        response = request.body(jsonObj.toString())
                .when()
                        .post("/assignments/" + nextAssignmentID + "?actionID=SearchCustomer");
    }

    @When("^I update the email address with \"([^\"]*)\"$")
    public void i_update_the_email_address_with(String emailAddress) throws Exception {
        JSONObject jsonObj = new JSONObject()
                .put("content", new JSONObject()
                        .put("CustomerInfo", new JSONObject()
                                .put("CustomerID", "51425410D")
                                .put("FirstName", "David")
                                .put("LastName", "Elvar")
                                .put("SecondName", "Calamonte")
                                .put("PhoneNumber", "658 917 059")
                                .put("EmailAddress", emailAddress)
                ));

        response = request.body(jsonObj.toString())
                .when()
                        .post("/assignments/" + nextAssignmentID + "?actionID=UpdateCustomer");
    }

    @Then("^The customer profile will be updated$")
    public void the_customer_profile_will_be_updated() throws Exception {
        response
                .then()
                        .statusCode(200)
                        .extract()
                        .body()
                        .path("nextAssignmentID");
    }

    @Then("^The customer profile will found$")
    public void the_customer_profile_will_found() throws Exception {
        nextAssignmentID = response
                .then()
                        .statusCode(200)
                        .extract()
                        .body()
                        .path("nextAssignmentID");
    }

    @Then("^The customer profile will not found$")
    public void the_customer_profile_will_not_found() throws Exception {
        response
                .then()
                    .assertThat()
                    .statusCode(400)
                .and()
                    .contentType(ContentType.JSON)
                .and()
                    .body("errors[0].ID", equalTo("Pega_API_055"))
                    .body("errors[0].message", equalTo("Validation messages found."))
                    .body("errors[0].ValidationMessages[0].ValidationMessage", startsWith("No records were found for the lookup with keys"));
    }
}