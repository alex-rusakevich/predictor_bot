import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.nio.file.Files
import java.nio.file.Paths

data class Prediction (val id: Integer, val text: String) {
    companion object {
        val predictionsUrl = Main::class.java.getResource("predictions.json")?.toURI()
            ?: throw Exception("Cannot load resources/predictions.json")
        val predictions: List<Prediction>

        init {
            val mapper = jacksonObjectMapper()
            predictions = mapper.readValue(Files.readString(Paths.get(predictionsUrl)))
        }

        fun getRandomPrediciton(): Prediction {
            return predictions.random()
        }
    }
}