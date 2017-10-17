package com.hindsightsoftware.upkeep.example

import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import processes.Login

class BasicSimulation extends Simulation {
  val conf = ConfigFactory.load("cloudformation.conf")
  val httpConf = http
    .baseURL(conf.getString("JIRAURL"))
    .acceptHeader("*/*")
    .userAgentHeader("Gatling")

  val scn = scenario("BasicSimulation")
    .exec(Login.login)
    .pause(1)

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)
}
