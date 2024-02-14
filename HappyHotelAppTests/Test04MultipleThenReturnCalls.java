����   4 �  Dcom/mockitotutorial/happyhotel/booking/Test04MultipleThenReturnCalls  java/lang/Object bookingService 7Lcom/mockitotutorial/happyhotel/booking/BookingService; paymentServiceMock 7Lcom/mockitotutorial/happyhotel/booking/PaymentService; roomServiceMock 4Lcom/mockitotutorial/happyhotel/booking/RoomService; bookingDAOMock 3Lcom/mockitotutorial/happyhotel/booking/BookingDAO; mailSenderMock 3Lcom/mockitotutorial/happyhotel/booking/MailSender; <init> ()V Code
     LineNumberTable LocalVariableTable this FLcom/mockitotutorial/happyhotel/booking/Test04MultipleThenReturnCalls; setup RuntimeVisibleAnnotations "Lorg/junit/jupiter/api/BeforeEach;  5com/mockitotutorial/happyhotel/booking/PaymentService
     org/mockito/Mockito ! " mock %(Ljava/lang/Class;)Ljava/lang/Object;	  $   & 2com/mockitotutorial/happyhotel/booking/RoomService	  ( 	 
 * 1com/mockitotutorial/happyhotel/booking/BookingDAO	  ,   . 1com/mockitotutorial/happyhotel/booking/MailSender	  0   2 5com/mockitotutorial/happyhotel/booking/BookingService
 1 4  5 �(Lcom/mockitotutorial/happyhotel/booking/PaymentService;Lcom/mockitotutorial/happyhotel/booking/RoomService;Lcom/mockitotutorial/happyhotel/booking/BookingDAO;Lcom/mockitotutorial/happyhotel/booking/MailSender;)V	  7   4should_CountAvailablePlaces_When_CalledMultipleTimes Lorg/junit/jupiter/api/Test;
 % ; < = getAvailableRooms ()Ljava/util/List;
  ? @ A when :(Ljava/lang/Object;)Lorg/mockito/stubbing/OngoingStubbing; C +com/mockitotutorial/happyhotel/booking/Room E Room 1
 B G  H (Ljava/lang/String;I)V
 J L K java/util/Collections M N singletonList $(Ljava/lang/Object;)Ljava/util/List; P R Q $org/mockito/stubbing/OngoingStubbing S A 
thenReturn
 J U V = 	emptyList
 1 X Y Z getAvailablePlaceCount ()I \ )org/junit/jupiter/api/function/Executable   ^ _ ` execute /(II)Lorg/junit/jupiter/api/function/Executable;  ^
 c e d  org/junit/jupiter/api/Assertions f g 	assertAll /([Lorg/junit/jupiter/api/function/Executable;)V expectedFirstCall I expectedSecondCall actualFirst actualSecond lambda$0 (II)V 
Exceptions q java/lang/Throwable
 c s t n assertEquals lambda$1 
SourceFile "Test04MultipleThenReturnCalls.java BootstrapMethods
 z | { "java/lang/invoke/LambdaMetafactory } ~ metafactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; y 
  � m n �  
  � u n �  InnerClasses � %java/lang/invoke/MethodHandles$Lookup � java/lang/invoke/MethodHandles Lookup                   	 
                      /     *� �                                        �     L*� � � #*%� � %� '*)� � )� +*-� � -� /*� 1Y*� #*� '*� +*� /� 3� 6�                $  0  K         L       8        9      �     Y*� '� :� >� BYD	� F� I� O � T� O W	<=*� 6� W>*� 6� W6� [Y� ]  SY� a  S� b�       "       ! & " ) # + % 3 & B ( X )    4    Y     ) 0 h i  + . j i  3 & k i  <  l i 
 m n  o     p    &     � r�           (      
 u n  o     p    &     � r�           (        v    w x       � � �   � � � �   
  � � � 