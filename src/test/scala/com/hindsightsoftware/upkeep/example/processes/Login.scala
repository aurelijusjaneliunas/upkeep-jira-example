package com.hindsightsoftware.upkeep.example.processes

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Login {
  // System.getProperty("url")
  var login = exec(http("Login")
    .post("/rest/auth/1/session")
    .header("Content-Type", "application/json")
    .body(StringBody("""{"username":"admin","password":"admin"}"""))
    .check(
      jsonPath("$..session.name").exists.saveAs("authSessionName"),
      jsonPath("$..session.value").exists.saveAs("authSessionValue")
    )
  )
}