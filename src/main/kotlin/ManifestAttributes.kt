import java.io.InputStream
import java.util.jar.Manifest

class ManifestAttributes {
    private var manifest: Manifest? = null

    fun getAttr(attributeName: String): String? {
        if (manifest == null) {
            ManifestAttributes::class.java.classLoader?.getResourceAsStream("META-INF/MANIFEST.MF")
                ?.use { stream: InputStream ->
                    manifest = Manifest(stream)
                }
        }

        return manifest?.mainAttributes?.getValue(attributeName)
    }
}