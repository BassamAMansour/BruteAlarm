package com.bassamworks.brutealarm.models

enum class DayOfWeek(val position: Int, val value: String) {

    MONDAY(0, "MONDAY"),
    TUESDAY(1, "TUESDAY"),
    WEDNESDAY(2, "WEDNESDAY"),
    THURSDAY(3, "THURSDAY"),
    FRIDAY(4, "FRIDAY"),
    SATURDAY(5, "SATURDAY"),
    SUNDAY(6, "SUNDAY");

    override fun toString(): String {
        return this.value
    }

    companion object {

        fun getDayFromIndex(index: Int): DayOfWeek {

            return when (index) {

                MONDAY.position -> MONDAY
                TUESDAY.position -> TUESDAY
                WEDNESDAY.position -> WEDNESDAY
                THURSDAY.position -> THURSDAY
                FRIDAY.position -> FRIDAY
                SATURDAY.position -> SATURDAY
                SUNDAY.position -> SUNDAY

                else -> throw Exception("Invalid day value!")
            }
        }

        fun getDayFromValue(value: String): DayOfWeek {

            return when (value.toUpperCase()) {

                MONDAY.value -> MONDAY
                TUESDAY.value -> TUESDAY
                WEDNESDAY.value -> WEDNESDAY
                THURSDAY.value -> THURSDAY
                FRIDAY.value -> FRIDAY
                SATURDAY.value -> SATURDAY
                SUNDAY.value -> SUNDAY

                else -> throw Exception("Invalid day value!")
            }

        }
    }
}