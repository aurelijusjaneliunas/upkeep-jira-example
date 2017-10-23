package com.hindsightsoftware.upkeep.example.processes

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object FetchIssues {
  var fetchIssues = exec(http("Fetch All Project Issues")
    .get("/rest/api/2/search?jql=project=\"SAM\"")
    .header("Content-Type", "application/json")
    .header("Accept", "*/*")
  )
}