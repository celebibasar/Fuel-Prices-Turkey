package com.basarcelebi.fuelpriceapp

import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

fun main() {
    // Şehir adını girin
    val sehirAdi = "İzmir"

    // HTTP istemini oluşturun
    val url = "http://hasanadiguzel.com.tr/api/akaryakit/sehir=$sehirAdi"
    val client = OkHttpClient()
    val request = Request.Builder()
        .url(url)
        .build()

    // API'den veriyi alın
    val response = client.newCall(request).execute()
    val jsonString = response.body?.string() ?: ""

    // JSON nesnesini oluşturun
    val jsonObject = JSONObject(jsonString)
    val data = jsonObject.getJSONObject("data")
    val ilceAdi = data.getString("Ilce_Adi")

    // Fiyatları yazdırın
    println("**$ilceAdi Benzin Fiyatları:**")
    println("  * Benzin 95 (Excellium95): ${data.getString("Kursunsuz_95(Excellium95)_TL_lt")}")
    println("  * Gaz Yağı: ${data.getString("Gazyagi_TL_lt")}")
    println("  * Motorin (Eurodiesel): ${data.getString("Motorin(Eurodiesel)_TL_lt")}")
    println("  * Motorin (Excellium_Eurodiesel): ${data.getString("Motorin(Excellium_Eurodiesel)_TL_lt")}")
    println("  * Kalorifer Yakıtı: ${data.getString("Kalorifer_Yakiti_TL_kg")}")
    println("  * Fuel Oil: ${data.getString("Fuel_Oil_TL_Kg")}")
    println("  * Yüksek Kükürtlü Fuel Oil: ${data.getString("Yüksek_Kükürtlü_Fuel_Oil_TL_kg")}")
    println("  * Otogaz: ${data.getString("Otogaz_TL_lt")}")
}