
package com.JPA.JavaPersistanceAPI.GeneralNotes;

import javax.persistence.CascadeType;

public enum Notes {
	
//	OneToOne, OneToMany vs gibi iliskilerde bir tarafın sahipliği alması gerekir.
//	Bunu da mappedBy ile belirliyoruz. mappedBy'ı neye göre ekleyiyoruz diye düsünecek olursak;
//	 personun passporta bağımlılığı olduğu için mappedBy Person class'ı icinde.
//	 Yani bağımlılığa ev sahipliği yapan nesne tarafına eklenir.
	 
	
//	Person ile passport arasındaki bağımlılığı da dikkate alınca;
//	person silindiğinde passport da silinsin istiyorsak ya da person bilgisini çektiğimiz de 
//	passport bilgilerinin de cekilmesini istiyorsak vs. islemler de "cascade" kullanıyoruz.
	
	
//	OneToOne = vatandas-kimlik.
//	OneToMany = Sepet-Sepetteki ürünler
//	ManyToMany = kanal-kanala abone olanlar 
//			bir kanalın birden fazla subscribersı olabilir, bir subscriber birden fazla kanala abone olabilir.
	
//	ManyToMany relationshiplerde  bir tane ara tabloya ihtiyac vardır. relationship bu tablo üzerinden yapılıyor.
	
//	cascade = CascadeType.REMOVE bunu carta eklediğimiz zaman cartı silersek iliskili oldugu kaydıda silecektir.
//			CascadeType.All mümkün oldukca kullanmamak lazım cünkü hepsini kapsıyor.
	

}
