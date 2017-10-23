package com.hindsightsoftware.upkeep.example

import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._
import processes.{FetchIssues, Login}

class BasicSimulation extends Simulation {
  val conf = ConfigFactory.load("cloudformation.conf")
  val httpConf = http
    .baseURL(conf.getString("JIRAURL"))
    .acceptHeader("*/*")
    .userAgentHeader("Gatling")

  val scn = scenario("BasicSimulation")
    .exec(Login.login)
    .pause(1)
    .exec(FetchIssues.fetchIssues)
    .pause(1)

  setUp(
    scn.inject(rampUsers(10) over (10 seconds))
  ).protocols(httpConf)
}
