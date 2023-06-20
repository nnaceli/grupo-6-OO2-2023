package com.unla.grupo6.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unla.grupo6.entities.UserRole;
import com.unla.grupo6.repositories.IUserRepository;

//REVISAR BIEN CON MUCHO DETALLE

@Service("userService")
public class UserService implements UserDetailsService {

	@Autowired
	@Qualifier("userRepository")
	private IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException{
		com.unla.grupo6.entities.User user = userRepository.findByUsernameAndFetchUserRolesEagerly(username);
		return buildUser(user, buildGrantedAuthorities(user.getUserRoles()));
	}

	private User buildUser(com.unla.grupo6.entities.User user, List<GrantedAuthority> grantedAuthorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, grantedAuthorities);
	}

	private List<GrantedAuthority> buildGrantedAuthorities(Set<UserRole> userRoles) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		for (UserRole userRole : userRoles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		return new ArrayList<>(grantedAuthorities);
	}

//	private Usuario buildUser (com.unla.grupo6.entities.Usuario user , List<GrantedAuthority> grantedAuthorities) {
//		return new Usuario (user.getUsuario(),  user.getContraseña(), user.isActivado(), true, true, true, grantedAuthorities); //error aca grantedAuthoritys
//	}
//
//	
//	private Object grantedAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private List<GrantedAuthority> buildGrantedAuthorities(Set<UsuarioAdministrador> usuarioAdministradores){
//		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>(); //error en el hashset
//		for(UsuarioAdministrador usuarioAdmin : usuarioAdministradores) {
//			grantedAuthorities.add(new SimpleGrantedAuthority(usuarioAdmin.getRole()));
//		}
//		
//		return new ArrayList<GrantedAuthority> (grantedAuthorities);
//	}
//	
//	
//	private UserDetails buildUser(Usuario usuario, Object buildGrantedAuthorities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private Object buildGrantedAuthorities(Object userRoles) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
