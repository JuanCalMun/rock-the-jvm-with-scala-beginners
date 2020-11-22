package lectures.part1basics

import java.util.UUID

object NamedArguments extends App {

  def printVehicleStatus(vehicleType: String = "car",
                         vehicleCode: String = UUID.randomUUID().toString,
                         mileage: Int = 0,
                         numberOfTires: Int = 4): Unit = {
    println(s"The $vehicleType $vehicleCode with $mileage km has $numberOfTires tires ok")
  }

  printVehicleStatus()
  printVehicleStatus(vehicleType = "boat", numberOfTires = 0)
  printVehicleStatus(vehicleType = "MotorCycle", numberOfTires = 2, mileage = 2000)

}
