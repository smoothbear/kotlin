package com.smoothbear.kotlin.domain.user.service

import com.smoothbear.jpa.domain.user.controller.dto.RegisterReq
import com.smoothbear.jpa.domain.user.domain.User
import com.smoothbear.jpa.domain.user.repository.UserRepository
import spock.lang.Specification

class UserServiceTest extends Specification {
    def "검증된 RegisterReq를 받아 회원가입을 진행하면 예외 없이 성공한다"() {
        given:
        def userRepository = Mock(UserRepository)
        UserService userService = new UserServiceImpl(userRepository)

        when:
        userService.register(new RegisterReq(email, password, name))

        then:
        userRepository.findById("smoothbear@gmail.com") >> null
        userRepository.findById(email) >> new User(0, email, password, name)

        where:
        email                  | password   | name
        "smoothbear@gmail.com" | "11111111" | "smoothbear"
        "tester@gmail.com"     | "11111111" | "tester"
        "tester@gmail.com"     | "test1111" | "tester"
    }
}
