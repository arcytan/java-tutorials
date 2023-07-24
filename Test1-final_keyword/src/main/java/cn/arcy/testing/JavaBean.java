package cn.arcy.testing;

public class JavaBean {
    private final Long id;

    //对于final的属性，可以通过构造函数来设置值
    public JavaBean (Long id)
    {
        this.id = id;
    }

    //对于设置为final的属性，不能直接赋值
    /*public void setId(Long id)
    {
        this.id = id;
    }*/

    public Long getId()
    {
        return id;
    }
}
