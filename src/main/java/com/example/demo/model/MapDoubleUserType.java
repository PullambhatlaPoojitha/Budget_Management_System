//import org.hibernate.type.AbstractSingleColumnStandardBasicType;
//import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;
//import org.hibernate.usertype.DynamicParameterizedType;
//
//public class JsonDoubleMapType
//        extends AbstractSingleColumnStandardBasicType<Map<String, Double>>
//        implements DynamicParameterizedType {
//
//    public JsonDoubleMapType() {
//        super(JsonDoubleMapSqlTypeDescriptor.INSTANCE, new JsonTypeDescriptor(Map.class));
//    }
//
//    @Override
//    public String getName() {
//        return "json_double_map";
//    }
//
//    @Override
//    public void setParameterValues(Properties parameters) {
//        ((JsonTypeDescriptor) getJavaTypeDescriptor()).setParameterValues(parameters);
//    }
//}
