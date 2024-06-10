package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Administrator;
import com.example.repository.AdministratorRepository;

import java.util.List;

/**
 * 管理者情報を操作するサービス.
 * 
 * @author igamasayuki
 *
 */
@Service
@Transactional
public class AdministratorService {

	@Autowired
	private AdministratorRepository administratorRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * 管理者情報を登録します.
	 * 
	 * @param administrator 管理者情報
	 */
	public void insert(Administrator administrator) {
		String hashedPassword = passwordEncoder.encode(administrator.getPassword());
		administrator.setPassword(hashedPassword);
		administratorRepository.insert(administrator);
	}

	/**
	 * ログインをします.
	 * 
	 * @param mailAddress メールアドレス
	 * @param password    パスワード
	 * @return 管理者情報 存在しない場合はnullが返ります
	 */
	public Administrator login(String mailAddress, String password) {
		Administrator administrator = administratorRepository.findByMailAddressAndPassword(mailAddress, password);
//		String hashedPassword = passwordEncoder.encode(password);
		if(passwordEncoder.matches(password,administrator.getPassword())){
			return administrator;
		}
		return null;
	}

	/**
	 * メールアドレスをもとに管理者情報を検索.
	 *
	 * @param mailAddress 検索するメールアドレス.
	 * @return メールアドレスで一致する管理者情報. 一致しない場合はNULL.
	 */
	public Administrator findByEmail(String mailAddress){
		return administratorRepository.findByMailAddress(mailAddress);
	}
}
