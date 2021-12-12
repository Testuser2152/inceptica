$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("JobSearch.feature");
formatter.feature({
  "line": 1,
  "name": "Automate Job search functionality scenario (with More search option)",
  "description": "",
  "id": "automate-job-search-functionality-scenario-(with-more-search-option)",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3435800,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Automate Job search functionality scenario",
  "description": "",
  "id": "automate-job-search-functionality-scenario-(with-more-search-option);automate-job-search-functionality-scenario",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@jobSearch"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User is on Cv libraray site",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User provides the Job details",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Click on FindJobs",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.user_is_on_cv_libraray_site()"
});
formatter.result({
  "duration": 9146769900,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_provides_the_job_details()"
});
formatter.result({
  "duration": 2720441000,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.click_on_findjobs()"
});
formatter.result({
  "duration": 215301900,
  "status": "passed"
});
formatter.after({
  "duration": 679686500,
  "status": "passed"
});
});