package somaApp;

/**
* somaApp/somaHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from soma.idl
* Ter�a-feira, 19 de Junho de 2018 22h16min51s GFT
*/

public final class somaHolder implements org.omg.CORBA.portable.Streamable
{
  public somaApp.soma value = null;

  public somaHolder ()
  {
  }

  public somaHolder (somaApp.soma initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = somaApp.somaHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    somaApp.somaHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return somaApp.somaHelper.type ();
  }

}
