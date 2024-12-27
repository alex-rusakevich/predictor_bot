import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.entities.ChatId
import io.github.cdimascio.dotenv.Dotenv

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val dotenv = Dotenv.load()

            val bot = bot {
                token = dotenv["BOT_TOKEN"]
                dispatch {
                    command("start") {
                        bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Привет! Я проведу тебя через энграммы и арканы бесконечного Космоса, только напиши мне /predict")
                    }
                    command("predict") {
                        bot.sendMessage(ChatId.fromId(message.chat.id), text = Prediction.getRandomPrediciton().text)
                    }
                }
            }
            bot.startPolling()
        }
    }
}
