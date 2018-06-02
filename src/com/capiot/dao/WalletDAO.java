package com.capiot.dao;

import com.capiot.entity.Wallet;

public interface WalletDAO {
	
	public void saveWallet(Wallet wallet);
	public Wallet getWallet(int walletId);
}
