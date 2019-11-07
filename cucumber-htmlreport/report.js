$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/demo.feature");
formatter.feature({
  "name": "Update customer case type",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Update existing customer profile",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "A new update customer case type",
  "keyword": "Given "
});
formatter.match({
  "location": "UpdateCaseDefinitions.a_new_update_customer_case_type()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I look for a customer with ID \"51425410D\"",
  "keyword": "When "
});
formatter.match({
  "location": "UpdateCaseDefinitions.i_look_for_a_customer_with_ID(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The customer profile will found",
  "keyword": "Then "
});
formatter.match({
  "location": "UpdateCaseDefinitions.the_customer_profile_will_found()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I update the email address with \"elvad@pega.com\"",
  "keyword": "And "
});
formatter.match({
  "location": "UpdateCaseDefinitions.i_update_the_email_address_with(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The customer profile will be updated",
  "keyword": "Then "
});
formatter.match({
  "location": "UpdateCaseDefinitions.the_customer_profile_will_be_updated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Customer profile not found",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "A new update customer case type",
  "keyword": "Given "
});
formatter.match({
  "location": "UpdateCaseDefinitions.a_new_update_customer_case_type()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I look for a customer with ID \"789123654F\"",
  "keyword": "When "
});
formatter.match({
  "location": "UpdateCaseDefinitions.i_look_for_a_customer_with_ID(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The customer profile will not found",
  "keyword": "Then "
});
formatter.match({
  "location": "UpdateCaseDefinitions.the_customer_profile_will_not_found()"
});
formatter.result({
  "status": "passed"
});
});