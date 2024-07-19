package br.com.gabrizord.springrestdemo.security.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public enum RoleName {

    BASIC(1L),
    ADMIN(2L);

    long roleId;

    RoleName(long roleId) {
        this.roleId = roleId;
    }
}
