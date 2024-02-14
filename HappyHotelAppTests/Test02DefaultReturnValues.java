����   4 r  @com/mockitotutorial/happyhotel/booking/Test02DefaultReturnValues  java/lang/Object bookingService 7Lcom/mockitotutorial/happyhotel/booking/BookingService; paymentServiceMock 7Lcom/mockitotutorial/happyhotel/booking/PaymentService; roomServiceMock 4Lcom/mockitotutorial/happyhotel/booking/RoomService; bookingDAOMock 3Lcom/mockitotutorial/happyhotel/booking/BookingDAO; mailSenderMock 3Lcom/mockitotutorial/happyhotel/booking/MailSender; <init> ()V Code
     LineNumberTable LocalVariableTable this BLcom/mockitotutorial/happyhotel/booking/Test02DefaultReturnValues; setup RuntimeVisibleAnnotations "Lorg/junit/jupiter/api/BeforeEach;  5com/mockitotutorial/happyhotel/booking/PaymentService
     org/mockito/Mockito ! " mock %(Ljava/lang/Class;)Ljava/lang/Object;	  $   & 2com/mockitotutorial/happyhotel/booking/RoomService	  ( 	 
 * 1com/mockitotutorial/happyhotel/booking/BookingDAO	  ,   . 1com/mockitotutorial/happyhotel/booking/MailSender	  0   2 5com/mockitotutorial/happyhotel/booking/BookingService
 1 4  5 �(Lcom/mockitotutorial/happyhotel/booking/PaymentService;Lcom/mockitotutorial/happyhotel/booking/RoomService;Lcom/mockitotutorial/happyhotel/booking/BookingDAO;Lcom/mockitotutorial/happyhotel/booking/MailSender;)V	  7  	 9 ; : java/lang/System < = out Ljava/io/PrintStream; ? java/lang/StringBuilder A List returned 
 > C  D (Ljava/lang/String;)V
 % F G H getAvailableRooms ()Ljava/util/List;
 > J K L append -(Ljava/lang/Object;)Ljava/lang/StringBuilder;
 > N O P toString ()Ljava/lang/String;
 R T S java/io/PrintStream U D println W Object returned 
 % Y Z [ findAvailableRoomId K(Lcom/mockitotutorial/happyhotel/booking/BookingRequest;)Ljava/lang/String;
 > ] K ^ -(Ljava/lang/String;)Ljava/lang/StringBuilder; ` Primitive returned  should_CountAvailablePlaces Lorg/junit/jupiter/api/Test;
 1 d e f getAvailablePlaceCount ()I
 h j i  org/junit/jupiter/api/Assertions k l assertEquals (II)V expected I actual 
SourceFile Test02DefaultReturnValues.java                   	 
                      /     *� �           
                             �     �*� � � #*%� � %� '*)� � )� +*-� � -� /*� 1Y*� #*� '*� +*� /� 3� 6� 8� >Y@� B*� '� E� I� M� Q� 8� >YV� B*� '� X� \� M� Q� 8� >Y_� B*� '� X� \� M� Q�       & 	        $  0  K  g  �  �          �       a        b      Z     <*� 6� c=� g�           %  ' 
 )  *                m n  
  o n   p    q