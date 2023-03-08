# Leap Year TDD Kata

It takes approximately 365.25 days for Earth to orbit the Sun — a solar year. We usually round the days in a calendar
year to 365. To make up for the missing partial day, we add one day to our calendar approximately every four years.
That is a leap year.

## Instructions

Implement a method that checks if a year is a leap year.

All the following rules must be satisfied:

* A year is not a leap year if not divisible by 4
* A year is a leap year if divisible by 4
* A year is a leap year if divisible by 400
* A year is not a leap year if divisible by 100 but not by 400

### Examples:

1997 is not a leap year (not divisible by 4)
1996 is a leap year (divisible by 4)
1600 is a leap year (divisible by 400)
1800 is not a leap year (divisible by 4, divisible by 100, NOT divisible by 400)
The method should return true if a year is a leap year, and false if it is not.