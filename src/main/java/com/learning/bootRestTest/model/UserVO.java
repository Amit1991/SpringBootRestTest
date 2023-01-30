package com.learning.bootRestTest.model;

import javax.persistence.*;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity @Data
@Table(name="_user")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserVO implements UserDetails {

	@Id
	@GeneratedValue
	private long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;

	@Enumerated(EnumType.STRING)
	private Role role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(this.role.name()));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public static UserVO unauthorisedUser() {

		return UserVO.builder().role(Role.UNAUTHORISED).build();
	}
}
