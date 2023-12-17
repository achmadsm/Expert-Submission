import com.example.core.data.source.remote.response.ListMovieResponse
import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Test

class ListMovieResponseTest {

    @Test
    fun testListMovieResponse() {
        // Sample JSON data representing a list of movie responses
        val json = """
            {
                "results": [
                    {
                        "id": 1,
                        "title": "Sample Movie 1",
                        "overview": "This is a sample movie overview 1.",
                        "poster_path": "/sample_poster1.jpg"
                    },
                    {
                        "id": 2,
                        "title": "Sample Movie 2",
                        "overview": "This is a sample movie overview 2.",
                        "poster_path": "/sample_poster2.jpg"
                    }
                ]
            }
        """.trimIndent()

        // Deserialize the JSON into a ListMovieResponse object
        val listMovieResponse = Gson().fromJson(json, ListMovieResponse::class.java)

        // Verify the values of the ListMovieResponse object and its nested MovieResponse objects
        assertEquals(2, listMovieResponse.results.size)

        // Verify the values of the first MovieResponse object
        assertEquals(1, listMovieResponse.results[0].id)
        assertEquals("Sample Movie 1", listMovieResponse.results[0].title)
        assertEquals("This is a sample movie overview 1.", listMovieResponse.results[0].overview)
        assertEquals("/sample_poster1.jpg", listMovieResponse.results[0].posterPath)

        // Verify the values of the second MovieResponse object
        assertEquals(2, listMovieResponse.results[1].id)
        assertEquals("Sample Movie 2", listMovieResponse.results[1].title)
        assertEquals("This is a sample movie overview 2.", listMovieResponse.results[1].overview)
        assertEquals("/sample_poster2.jpg", listMovieResponse.results[1].posterPath)
    }
}
