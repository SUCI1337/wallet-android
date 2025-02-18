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
package com.tari.android.wallet.service;

// import model classes
import com.tari.android.wallet.model.Model;
import com.tari.android.wallet.service.TariWalletServiceListener;

interface TariWalletService {

    /**
    * Registers new wallet listener.
    * Registered listener will be unregistered on death.
    */
    boolean registerListener(TariWalletServiceListener listener);

    /**
    * Unregisters wallet listener.
    */
    boolean unregisterListener(TariWalletServiceListener listener);

    String getWalletAddressHexString(out WalletError error);

    BalanceInfo getBalanceInfo(out WalletError error);

    MicroTari estimateTxFee(in MicroTari amount, out WalletError error, in MicroTari feePerGram);

    List<TariContact> getContacts(out WalletError error);

    List<CompletedTx> getCompletedTxs(out WalletError error);
    CompletedTx getCompletedTxById(in TxId id, out WalletError error);

    List<PendingInboundTx> getPendingInboundTxs(out WalletError error);
    PendingInboundTx getPendingInboundTxById(in TxId id, out WalletError error);

    List<PendingOutboundTx> getPendingOutboundTxs(out WalletError error);
    PendingOutboundTx getPendingOutboundTxById(in TxId id, out WalletError error);

    List<CancelledTx> getCancelledTxs(out WalletError error);
    CancelledTx getCancelledTxById(in TxId id, out WalletError error);

    boolean cancelPendingTx(in TxId id, out WalletError error);

    /**
    * Sets the base node peer that the wallet syncs with.
    */
    boolean addBaseNodePeer(
        in String baseNodePublicKey,
        in String baseNodeAddress,
        out WalletError error
    );

    boolean startBaseNodeSync(out WalletError error);

    TxId sendTari(
        in TariContact contact,
        in MicroTari amount,
        in MicroTari feePerGram,
        String message,
        boolean isOneSidePayment,
        out WalletError error
    );

    boolean updateContact(in TariWalletAddress address, in String alias, boolean isFavorite, out WalletError error);

    boolean removeContact(in TariContact contact, out WalletError error);

    /**
    * Two functions below to get the public key from emoji id and public key hex string
    * do not accept out error parameters - they will just return null if a public key
    * cannot be constructed from input parameters.
    */
    TariWalletAddress getWalletAddressFromEmojiId(in String emojiId);
    TariWalletAddress getWalletAddressFromHexString(in String hex);

    /**
    * Key-value storage functions.
    */
    boolean setKeyValue(in String key, in String value, out WalletError error);
    String getKeyValue(in String key, out WalletError error);
    boolean removeKeyValue(in String key, out WalletError error);

    /**
    * Required confirmation count functions.
    */
    long getRequiredConfirmationCount(out WalletError error);
    void setRequiredConfirmationCount(long number, out WalletError error);

    /**
    * Seed words.
    */
    List<String> getSeedWords(out WalletError error);

    TariVector getUtxos(int page, int pageSize, int sorting, out WalletError error);

    TariVector getAllUtxos(out WalletError error);

    TariCoinPreview previewJoinUtxos(in List<TariUtxo> utxos, out WalletError error);

    TariCoinPreview previewSplitUtxos(in List<TariUtxo> utxos, int splitCount, out WalletError error);

    void joinUtxos(in List<TariUtxo> utxos, out WalletError error);

    void splitUtxos(in List<TariUtxo> utxos, int splitCount, out WalletError error);

    List<TariUnblindedOutput> getUnbindedOutputs(out WalletError error);

    void restoreWithUnbindedOutputs(in List<String> jsons, in TariWalletAddress address, in String message, out WalletError error);
}
