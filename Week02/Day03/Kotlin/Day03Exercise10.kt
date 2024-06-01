class DriverLicense(
    var name: String,
    var licenseNumber: Int,
    var cardNumber: Int,
    var dateOfBirth: String,
    var expirationDate: String
) {

    fun printDetails() {
        println("Name: $name \nDOB: $dateOfBirth \nCard no: $cardNumber \nLicense no: $licenseNumber \nExpiry date: $expirationDate")
    }

}

fun main() {

    var person1 = DriverLicense("Nikola", 123456, 258789, "01-06-1988", "28-08-2023")
    person1.printDetails()
}