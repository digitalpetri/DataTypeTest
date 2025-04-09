package com.digitalpetri.opcua.test.types;

import org.eclipse.milo.opcua.stack.core.types.UaEnumeratedType;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExpandedNodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.structured.EnumDefinition;
import org.eclipse.milo.opcua.stack.core.types.structured.EnumField;
import org.jspecify.annotations.Nullable;

public enum TestEnumType implements UaEnumeratedType {
  A(0),

  B(1),

  C(2);

  private final int value;

  TestEnumType(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }

  @Override
  public ExpandedNodeId getTypeId() {
    return TypeInfo.TYPE_ID;
  }

  public static @Nullable TestEnumType from(int value) {
    switch(value) {
      case 0: return A;
      case 1: return B;
      case 2: return C;
      default: return null;
    }
  }

  public static EnumDefinition definition() {
    return new EnumDefinition(new EnumField[]{
        new EnumField(0L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "A"), 
        new EnumField(1L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "B"), 
        new EnumField(2L, LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE, "C")
        });
  }

  public static final class TypeInfo {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("ns=1;i=3011");
  }
}
