package com.smoothbear.kotlin.domain.user.service

import com.smoothbear.kotlin.domain.user.controller.dto.RegisterReq
import com.smoothbear.kotlin.domain.user.domain.User
import com.smoothbear.kotlin.domain.user.exception.UserAlreadyExistsException
import com.smoothbear.kotlin.domain.user.repository.UserRepository
import spock.lang.Specification
import spock.lang.Unroll

class UserServiceTest extends Specification {
    @Unroll
    def "RegisterReq를 받아 데이터베이스에 삽입하면 예외 없이 성공한다 [이메일: #email, 패스워드: #password, 이름: #name]"() {
        given:
        def userRepository = Mock(UserRepository)
        UserService userService = new UserServiceImpl(userRepository)

        when:
        userService.register(new RegisterReq(email, password, name))

        then:
        userRepository.findById(email) >> Optional.empty()

        notThrown UserAlreadyExistsException

        where:
        email                  | password   | name
        "smoothbear@gmail.com" | "11111111" | "smoothbear"
        "tester@gmail.com"     | "11111111" | "tester"
        "test@gmail.com"       | "test1111" | "tester"
    }

    @Unroll
    def "DB에 이미 있는 이메일로 데이터베이스에 삽입하면 UserAlreadyExistsException이 발생한다 [이메일: #email, 패스워드: #password, 이름: #name]"() {
        given:
        def userRepository = Mock(UserRepository)
        UserService userService = new UserServiceImpl(userRepository)

        when:
        userService.register(new RegisterReq(email, password, name))

        then:
        userRepository.findById(email) >> Optional.of(new User(null, email, password, name))
        thrown UserAlreadyExistsException

        where:
        email              | password   | name
        "test@gmail.com"   | "11111111" | "tester"
        "tester@gmail.com" | "testtest" | "test"
        "user@gmail.com"   | "test1111" | "user"
    }
}
