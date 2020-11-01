object MockWebServerUtils {
    /**
     * Mock server response so we can isolate testing our API calls.
     */
    @Suppress("SameParameterValue")
   fun getMockedHttpResponse(
        fileName: String? = null,
        responseCode: Int? = null
    ) : MockResponse {
        val mockResponse = MockResponse()
        responseCode?.let {
            mockResponse.setResponseCode(it)
        }
        fileName?.let {
            mockResponse.setBody(getJson("api-response/$fileName"))
        }
        return mockResponse
    }

    /**
     * Get test JSON
     */
   private fun getJson(path: String): String {
        val uri = javaClass.classLoader!!.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }
}