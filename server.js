const exec = require('child_process').execSync

const JAR_VERSION = process.env.JAR_VERSION ?? process.argv[2]

if (!JAR_VERSION) {
    throw new Error("Cannot start the server: JAR_VERSION is missing")
}

const JAR_NAME = `predictorbot-${JAR_VERSION}.jar`

console.log(`Starting jar ${JAR_NAME}...`)
exec(`java -jar ${JAR_NAME}`, { stdio: 'inherit' })
