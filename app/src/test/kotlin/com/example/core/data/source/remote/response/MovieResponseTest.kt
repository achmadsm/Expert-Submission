package com.example.core.data.source.remote.response

import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Test

class MovieResponseTest {

    @Test
    fun testMovieResponse() {
        // Sample JSON data representing a movie response
        val json = """
            {
                "id": 1,
                "title": "Sample Movie",
                "overview": "This is a sample movie overview.",
                "poster_path": "/sample_poster.jpg"
            }
        """.trimIndent()

        // Deserialize the JSON into a MovieResponse object
        val movieResponse = Gson().fromJson(json, MovieResponse::class.java)

        // Verify the values of the MovieResponse object
        assertEquals(1, movieResponse.id)
        assertEquals("Sample Movie", movieResponse.title)
        assertEquals("This is a sample movie overview.", movieResponse.overview)
        assertEquals("/sample_poster.jpg", movieResponse.posterPath)
    }
}