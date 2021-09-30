package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping(value = "/user")
public class UserController {

//	@Autowired
	private final UserRepository userRepo;

	public UserController(UserRepository userRepositoy) {
		this.userRepo = userRepositoy;
	}

	private UserDto toDto(User user) {
		return new UserDto(user.getLoginId(), user.getName(), user.getPassword());
	}

	@GetMapping(value = "/get-all")
	public List<UserDto> getAll() {
		List<User> userList = this.userRepo.findAll();
		return userList.stream().map(this::toDto).collect(Collectors.toList());
//		for(User user:userList) {
//			UserDto dto = new UserDto();
//			BeanUtils.copyProperties(user, dto);
//			result.add(dto);
//		}
//		return result;
	}

	@PostMapping(value = "/save")
	public String save(@RequestBody UserDto dto) {
		User user = User.builder().name(dto.getName()).loginId(dto.getLoginId()).password(dto.getPassword()).build();
		return userRepo.save(user).getLoginId();
		
	}
	
	@PostMapping(value = "/save-list")
	public Integer save(@RequestBody List<UserDto> dtoList) {
		for(UserDto dto:dtoList) {
				this.save(dto);
		}
		return dtoList.size();
		
	}
}
