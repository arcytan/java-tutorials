package cn.arcy.testing.specifications;

import cn.arcy.testing.entities.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecs {

    public static Specification<User> isArcy()
    {
        return ((root, query, builder) -> builder.equal(root.get("nickname"), "arcy"));
    }

    public static Specification<User> isHogalei()
    {
        return ((root, query, builder) -> {
            return builder.equal(root.get("nickname"), "hogalei");
        });
    }
}
