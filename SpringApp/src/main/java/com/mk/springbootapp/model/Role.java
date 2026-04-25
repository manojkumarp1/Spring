package com.mk.springbootapp.model;

import java.util.Set;

public enum Role {
	ADMIN(Set.of(Permissions.EMP_READ, Permissions.EMP_WRITE, Permissions.EMP_DELETE)),
	USER(Set.of(Permissions.EMP_READ));

	private final Set<Permissions> permissions;

	Role(Set<Permissions> permissions) {
		this.permissions = permissions;
	}
	
	public Set<Permissions> getPermissions(){
		return permissions;
	}
}
