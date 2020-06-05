package ua.lviv.ura.univer.security;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ua.lviv.ura.univer.dao.UserRepository;
import ua.lviv.ura.univer.dao.UserRoleRepository;
import ua.lviv.ura.univer.domain.User;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> userOptional = userRepository.findByEmail(email);
		
		if(userOptional.isPresent()) {
			List<String> userRoles = userRoleRepository.findRolesByUserName(email);
			return new CustomUserDetails(userOptional.get(), userRoles);
		}
		throw new UsernameNotFoundException("Not userEmail: " + email);
		
	}

}
