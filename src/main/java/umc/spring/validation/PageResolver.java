package umc.spring.validation;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc.spring.global.exception.InvalidValueException;

@Component
public class PageResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CustomPage.class) &&
                parameter.getParameterType().equals(Integer.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        String pageParam = webRequest.getParameter("page");

        if (pageParam == null) {
            throw new InvalidValueException("page 파라미터는 필수입니다.");
        }

        int page;
        try {
            page = Integer.parseInt(pageParam);
        } catch (NumberFormatException e) {
            throw new InvalidValueException("page는 숫자여야 합니다.");
        }

        if (page < 1) {
            throw new InvalidValueException("page는 1 이상의 값이어야 합니다.");
        }

        return page - 1; // 실제 JPA는 0부터 시작
    }
}