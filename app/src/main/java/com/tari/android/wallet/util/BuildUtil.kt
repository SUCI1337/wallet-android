/**
 * Copyright 2020 The Tari Project
 *
 * Redistribution and use in source and binary forms, with or
 * without modification, are permitted provided that the
 * following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of
 * its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
 * CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.tari.android.wallet.util

import com.tari.android.wallet.BuildConfig
import com.tari.android.wallet.model.TariWalletAddress

object TariBuild {

    private val _mockedTurned = true
    val MOCKED = _mockedTurned && BuildConfig.BUILD_TYPE == "debug"

    val mocked_emojiId =
        "\uD83C\uDFB9\uD83C\uDFA4\uD83C\uDF20\uD83C\uDFAA\uD83D\uDC16\uD83C\uDF5A\uD83D\uDE08\uD83C\uDF73\uD83C\uDFED\uD83D\uDC2F\uD83D\uDC29\uD83D\uDC33\uD83D\uDC2D\uD83D\uDC35\uD83D\uDC11\uD83C\uDF4E\uD83D\uDE02\uD83C\uDFB3\uD83C\uDF34\uD83C\uDF6D\uD83D\uDC0D\uD83C\uDF1F\uD83D\uDCBC\uD83C\uDFB9\uD83D\uDC3A\uD83D\uDC79\uD83C\uDF77\uD83D\uDC3B\uD83D\uDEAB\uD83D\uDE92\uD83D\uDCB3\uD83C\uDFAE\uD83D\uDD2A"
    val mocked_hex = "5A4A0A4F7427E33469858088838A721FE1560C316F09C55A8EA6388FFBF1C152DA"

    val mocked_zero_emojiId = (0..25).map { "\uD83C\uDF00" }.joinToString("")
    val mocked_zero_hex = TariWalletAddress.zero66Hex

    val mocked_wallet_address
//        get() = TariWalletAddress(mocked_hex, mocked_emojiId)
        get() = TariWalletAddress(
    "C05575BE00EF016A209B1F493D9027B0E330F3E25FE89BBE6FA66D966EE5B6356",
            "\uD83C\uDF34\uD83C\uDF0D\uD83C\uDFB5\uD83C\uDFBA\uD83D\uDDFD\uD83C\uDF37\uD83D\uDE91\uD83C\uDF45\uD83D\uDC60\uD83C\uDF1F\uD83D\uDC8C\uD83D\uDE97\uD83D\uDC40\uD83D\uDD29\uD83C\uDF08\uD83D\uDC1D\uD83C\uDF37\uD83C\uDF70\uD83C\uDF38\uD83C\uDF81\uD83C\uDF55\uD83D\uDEBF\uD83D\uDC34\uD83D\uDCA6\uD83D\uDE0E\uD83D\uDEAA\uD83C\uDFE0\uD83D\uDD29\uD83C\uDFE0\uD83D\uDE82\uD83C\uDFBA\uD83C\uDFC6\uD83C\uDFB3")

    val moched_zero_contact
        get() = TariWalletAddress(mocked_zero_hex, mocked_zero_emojiId)

    val isChat = false
}