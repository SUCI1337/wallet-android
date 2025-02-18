package com.tari.android.wallet.ui.fragment.contact_book.data.localStorage

import android.content.SharedPreferences
import com.tari.android.wallet.data.repository.CommonRepository
import com.tari.android.wallet.data.sharedPrefs.delegates.SharedPrefGsonDelegate
import com.tari.android.wallet.data.sharedPrefs.network.NetworkRepository
import com.tari.android.wallet.data.sharedPrefs.network.formatKey
import com.tari.android.wallet.ui.fragment.contact_book.data.contacts.ContactDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContactSharedPrefRepository @Inject constructor(
    networkRepository: NetworkRepository,
    val sharedPrefs: SharedPreferences
) : CommonRepository(networkRepository) {

    private var savedContacts: ContactsList? by SharedPrefGsonDelegate(sharedPrefs, this,  formatKey(KEY_SAVED_CONTACTS), ContactsList::class.java, ContactsList())

    fun getSavedContacts(): List<ContactDto> = savedContacts.orEmpty().map { ContactDtoSerializable.toContactDto(it) }

    @Synchronized
    fun saveContacts(list: List<ContactDto>) {
        savedContacts = ContactsList(list.map { ContactDtoSerializable.fromContactDto(it) })
    }

    fun clear() {
        savedContacts = null
    }

    companion object {
        const val KEY_SAVED_CONTACTS = "KEY_SAVED_CONTACTS"
    }
}