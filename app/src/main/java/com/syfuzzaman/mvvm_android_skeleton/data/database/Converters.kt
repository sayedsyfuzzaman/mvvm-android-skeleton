package com.syfuzzaman.mvvm_android_skeleton.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.syfuzzaman.mvvm_android_skeleton.data.network.api.Address
import com.syfuzzaman.mvvm_android_skeleton.data.network.api.Bank
import com.syfuzzaman.mvvm_android_skeleton.data.network.api.Company
import com.syfuzzaman.mvvm_android_skeleton.data.network.api.Crypto
import com.syfuzzaman.mvvm_android_skeleton.data.network.api.Hair

class Converters {
    private val gson = Gson()

    // Hair
    @TypeConverter
    fun fromHair(hair: Hair?): String? {
        return gson.toJson(hair)
    }

    @TypeConverter
    fun toHair(hairString: String?): Hair? {
        return gson.fromJson(hairString, Hair::class.java)
    }

    // Address
    @TypeConverter
    fun fromAddress(address: Address?): String? {
        return gson.toJson(address)
    }

    @TypeConverter
    fun toAddress(addressString: String?): Address? {
        return gson.fromJson(addressString, Address::class.java)
    }

    // Bank
    @TypeConverter
    fun fromBank(bank: Bank?): String? {
        return gson.toJson(bank)
    }

    @TypeConverter
    fun toBank(bankString: String?): Bank? {
        return gson.fromJson(bankString, Bank::class.java)
    }

    // Company
    @TypeConverter
    fun fromCompany(company: Company?): String? {
        return gson.toJson(company)
    }

    @TypeConverter
    fun toCompany(companyString: String?): Company? {
        return gson.fromJson(companyString, Company::class.java)
    }

    // Crypto
    @TypeConverter
    fun fromCrypto(crypto: Crypto?): String? {
        return gson.toJson(crypto)
    }

    @TypeConverter
    fun toCrypto(cryptoString: String?): Crypto? {
        return gson.fromJson(cryptoString, Crypto::class.java)
    }

    // Generic Type Converters for Lists (Optional)
    @TypeConverter
    fun fromStringList(list: List<String>?): String? {
        return gson.toJson(list)
    }

    @TypeConverter
    fun toStringList(listString: String?): List<String>? {
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(listString, type)
    }

    @TypeConverter
    fun fromIntList(list: List<Int>?): String? {
        return gson.toJson(list)
    }

    @TypeConverter
    fun toIntList(listString: String?): List<Int>? {
        val type = object : TypeToken<List<Int>>() {}.type
        return gson.fromJson(listString, type)
    }
}
