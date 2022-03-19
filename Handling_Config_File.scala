/*
libs

"com.typesafe" % "config" % "1.3.2"


*/

import com.typesafe.config.{Config, ConfigFactory, ConfigResolveOption}

val config : Config = ConfigFactory.parseFile(new File(configPath)).resolve

config.getString("step1.step2.step3")
config.getConfig("myConfig")

/*
Example.conf

step1{
  step2{
    step3{
      config1: 
      config2: 
    }
  }
}
*/
