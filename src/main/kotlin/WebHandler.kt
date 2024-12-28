import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler

class WebHandler : HttpHandler {
    override fun handle(exchange: HttpExchange) {
        exchange.responseHeaders["Location"] = "https://t.me/predictor_magnus_bot"
        exchange.sendResponseHeaders(302, -1)
    }
}