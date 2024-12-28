import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.logging.LogLevel
import io.github.cdimascio.dotenv.Dotenv
import java.util.logging.ConsoleHandler
import java.util.logging.FileHandler
import java.util.logging.Logger
import java.util.logging.SimpleFormatter


fun main() {
    val dotenv = Dotenv.load()

    //region Configure logger
    val logger = Logger.getLogger("MainKt")

    val fh = FileHandler("log.txt", true)
    val fhFormatter = SimpleFormatter()
    fh.formatter = fhFormatter
    logger.addHandler(fh)
    //endregion

    val serverVersion = ManifestAttributes().getAttr("Implementation-Version") ?: "dev"
    val programName = ManifestAttributes().getAttr("Implementation-Title") ?: "bot"
    logger.info("Starting $programName, version: $serverVersion")

    val bot = bot {
        token = dotenv["BOT_TOKEN"]
        logLevel = LogLevel.Error
        dispatch {
            command("start") {
                bot.sendMessage(
                    chatId = ChatId.fromId(message.chat.id),
                    text = "Привет! Я проведу тебя через энграммы и арканы бесконечного Космоса, только напиши мне /predict"
                )
            }
            command("predict") {
                val predictionText = Prediction.getRandomPrediction().text
                bot.sendMessage(ChatId.fromId(message.chat.id), text = predictionText)
            }
        }
    }

    bot.startPolling()
}
