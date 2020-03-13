import java.math.RoundingMode

class SpaceAge(private val seconds: Long) {

    fun onEarth(): Double = getSpaceAge(seconds, OrbitalPeriod.EARTH.earthYears)
    fun onMercury(): Double = getSpaceAge(seconds, OrbitalPeriod.MERCURY.earthYears)
    fun onVenus(): Double = getSpaceAge(seconds, OrbitalPeriod.VENUS.earthYears)
    fun onMars(): Double = getSpaceAge(seconds, OrbitalPeriod.MARS.earthYears)
    fun onJupiter(): Double = getSpaceAge(seconds, OrbitalPeriod.JUPITER.earthYears)
    fun onSaturn(): Double = getSpaceAge(seconds, OrbitalPeriod.SATURN.earthYears)
    fun onUranus(): Double = getSpaceAge(seconds, OrbitalPeriod.URANUS.earthYears)
    fun onNeptune(): Double = getSpaceAge(seconds, OrbitalPeriod.NEPTUNE.earthYears)

    private fun getSpaceAge(seconds: Long, earthYears: Double): Double {
        return (seconds / SECONDS_PER_EARTH_YEAR / earthYears).setScale(2)
    }

    private fun Double.setScale(scale: Int): Double {
        return this.toBigDecimal().setScale(scale, RoundingMode.HALF_UP).toDouble()
    }

    companion object {
        private const val SECONDS_PER_EARTH_YEAR = 60 * 60 * 24 * 365.25
    }

    enum class OrbitalPeriod(val earthYears: Double) {
        EARTH(1.0),
        MERCURY(0.2408467),
        VENUS(0.61519726),
        MARS(1.8808158),
        JUPITER(11.862615),
        SATURN(29.447498),
        URANUS(84.016846),
        NEPTUNE(164.79132)
    }
}
