package com.example.androidfinalproject

import okhttp3.Interceptor
import okhttp3.Response

private const val API_KEY = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6ImFjYjY3ZTUwLTU5Y2YtNDQwMC1hYmMxLWVmM2MwYWU0ODIxNSIsImlhdCI6MTYyMzE1NTYzOSwic3ViIjoiZGV2ZWxvcGVyL2M2M2Q0NmE5LWJmYzgtYjg0Ny1jZGRkLWExNzVlNDE2YzM4MSIsInNjb3BlcyI6WyJyb3lhbGUiXSwibGltaXRzIjpbeyJ0aWVyIjoiZGV2ZWxvcGVyL3NpbHZlciIsInR5cGUiOiJ0aHJvdHRsaW5nIn0seyJjaWRycyI6WyIyMDYuMTg5LjIwNS4yNTEiXSwidHlwZSI6ImNsaWVudCJ9XX0.KuxcgGtrFgw3IOfUXpqU_KSb37eJ8zbIUrVmvwlc-iLwLHS9LqItYFgkWWw9X0GFgZ04ahsoDjMIEnGewrPNJA"
class MyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authenticator", "Bearer " + API_KEY)
            .build()
        return chain.proceed(request)
    }
}