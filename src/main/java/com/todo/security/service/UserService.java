package com.todo.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.todo.security.dto.JoinRequest;
import com.todo.security.dto.LoginRequest;
import com.todo.security.entity.User;
import com.todo.security.repositories.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	// Spring Security를 사용한 로그인 구현 시 사용
	private final BCryptPasswordEncoder encoder;

	public boolean checkLoginIdDuplicate(String loginId) {
		return userRepository.existsByLoginId(loginId);
	}

	public boolean checkNicknameDuplicate(String nickname) {
		return userRepository.existsByNickname(nickname);
	}

	public void join(JoinRequest req) {
		userRepository.save(req.toEntity());
	}

	public User login(LoginRequest req) {
		Optional<User> optionalUser = userRepository.findByLoginId(req.getLoginId());

		if (optionalUser.isEmpty()) {
			return null;
		}

		User user = optionalUser.get();

		// 찾아온 User의 password와 입력된 password가 다르면 null return
		if (!user.getPassword().equals(req.getPassword())) {
			return null;
		}

		return user;
	}

	public User getLoginUserById(Long userId) {
		if (userId == null)
			return null;

		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isEmpty())
			return null;

		return optionalUser.get();
	}

	// 인증, 인가
	public User getLoginUserByLoginId(String loginId) {
		if (loginId == null)
			return null;

		Optional<User> optionalUser = userRepository.findByLoginId(loginId);
		if (optionalUser.isEmpty())
			return null;

		return optionalUser.get();
	}
	
	public List<User> showAll() {
		return userRepository.findAll();
	}

}
