import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

data class Prediction(val id: Int, val text: String) {
    companion object {
        private val predictionsJson =
            Prediction::class.java.getResourceAsStream("/predictions.json")?.bufferedReader()?.readText()
                ?: throw Exception("Cannot load resources/predictions.json: the file is either empty or missing")
        private val predictions: List<Prediction>

        init {
            val mapper = jacksonObjectMapper()
            predictions = mapper.readValue(predictionsJson)
        }

        fun getRandomPrediction(): Prediction {
            return predictions.random()
        }
    }
}