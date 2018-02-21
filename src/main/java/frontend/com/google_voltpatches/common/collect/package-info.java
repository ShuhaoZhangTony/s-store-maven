/*
 * Copyright (C) 2007 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * This package contains generic collection interfaces and implementations, and
 * other utilities for working with collections. It is a part of the open-source
 * <a href="http://guava-libraries.googlecode.com">Guava libraries</a>.
 *
 * <h2>Collection Types</h2>
 *
 * <dl>
 * <dt>{@link frontend.com.google_voltpatches.common.collect.BiMap}
 * <dd>An extension of {@link java.util.Map} that guarantees the uniqueness of
 *     its values as well as that of its keys. This is sometimes called an
 *     "invertible map," since the restriction on values enables it to support
 *     an {@linkplain frontend.com.google_voltpatches.common.collect.BiMap#inverse inverse view} --
 *     which is another instance of {@code BiMap}.
 *
 * <dt>{@link frontend.com.google_voltpatches.common.collect.Multiset}
 * <dd>An extension of {@link java.util.Collection} that may contain duplicate
 *     values like a {@link java.util.List}, yet has order-independent equality
 *     like a {@link java.util.Set}.  One typical use for a multiset is to
 *     represent a histogram.
 *
 * <dt>{@link frontend.com.google_voltpatches.common.collect.Multimap}
 * <dd>A new type, which is similar to {@link java.util.Map}, but may contain
 *     multiple entries with the same key. Some behaviors of
 *     {@link frontend.com.google_voltpatches.common.collect.Multimap} are left unspecified and are
 *     provided only by the subtypes mentioned below.
 *
 * <dt>{@link frontend.com.google_voltpatches.common.collect.ListMultimap}
 * <dd>An extension of {@link frontend.com.google_voltpatches.common.collect.Multimap} which permits
 *     duplicate entries, supports random access of values for a particular key,
 *     and has <i>partially order-dependent equality</i> as defined by
 *     {@link frontend.com.google_voltpatches.common.collect.ListMultimap#equals(Object)}. {@code
 *     ListMultimap} takes its name from the fact that the {@linkplain
 *     frontend.com.google_voltpatches.common.collect.ListMultimap#get collection of values}
 *     associated with a given key fulfills the {@link java.util.List} contract.
 *
 * <dt>{@link frontend.com.google_voltpatches.common.collect.SetMultimap}
 * <dd>An extension of {@link frontend.com.google_voltpatches.common.collect.Multimap} which has
 *     order-independent equality and does not allow duplicate entries; that is,
 *     while a key may appear twice in a {@code SetMultimap}, each must map to a
 *     different value.  {@code SetMultimap} takes its name from the fact that
 *     the {@linkplain frontend.com.google_voltpatches.common.collect.SetMultimap#get collection of
 *     values} associated with a given key fulfills the {@link java.util.Set}
 *     contract.
 *
 * <dt>{@link frontend.com.google_voltpatches.common.collect.SortedSetMultimap}
 * <dd>An extension of {@link frontend.com.google_voltpatches.common.collect.SetMultimap} for which
 *     the {@linkplain frontend.com.google_voltpatches.common.collect.SortedSetMultimap#get
 *     collection values} associated with a given key is a
 *     {@link java.util.SortedSet}.
 *
 * <dt>{@link frontend.com.google_voltpatches.common.collect.Table}
 * <dd>A new type, which is similar to {@link java.util.Map}, but which indexes
 *     its values by an ordered pair of keys, a row key and column key.
 *
 * <dt>{@link frontend.com.google_voltpatches.common.collect.ClassToInstanceMap}
 * <dd>An extension of {@link java.util.Map} that associates a raw type with an
 *     instance of that type.
 * </dl>
 *
 * <h2>Collection Implementations</h2>
 *
 * <h3>of {@link java.util.List}</h3>
 * <ul>
 * <li>{@link frontend.com.google_voltpatches.common.collect.ImmutableList}
 * </ul>
 *
 * <h3>of {@link java.util.Set}</h3>
 * <ul>
 * <li>{@link frontend.com.google_voltpatches.common.collect.ImmutableSet}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ImmutableSortedSet}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ContiguousSet} (see {@code Range})
 * </ul>
 *
 * <h3>of {@link java.util.Map}</h3>
 * <ul>
 * <li>{@link frontend.com.google_voltpatches.common.collect.ImmutableMap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ImmutableSortedMap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.MapMaker}
 * </ul>
 *
 * <h3>of {@link frontend.com.google_voltpatches.common.collect.BiMap}</h3>
 * <ul>
 * <li>{@link frontend.com.google_voltpatches.common.collect.ImmutableBiMap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.HashBiMap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.EnumBiMap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.EnumHashBiMap}
 * </ul>
 *
 * <h3>of {@link frontend.com.google_voltpatches.common.collect.Multiset}</h3>
 * <ul>
 * <li>{@link frontend.com.google_voltpatches.common.collect.ImmutableMultiset}
 * <li>{@link frontend.com.google_voltpatches.common.collect.HashMultiset}
 * <li>{@link frontend.com.google_voltpatches.common.collect.LinkedHashMultiset}
 * <li>{@link frontend.com.google_voltpatches.common.collect.TreeMultiset}
 * <li>{@link frontend.com.google_voltpatches.common.collect.EnumMultiset}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ConcurrentHashMultiset}
 * </ul>
 *
 * <h3>of {@link frontend.com.google_voltpatches.common.collect.Multimap}</h3>
 * <ul>
 * <li>{@link frontend.com.google_voltpatches.common.collect.ImmutableMultimap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ImmutableListMultimap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ImmutableSetMultimap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ArrayListMultimap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.HashMultimap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.TreeMultimap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.LinkedHashMultimap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.LinkedListMultimap}
 * </ul>
 *
 * <h3>of {@link frontend.com.google_voltpatches.common.collect.Table}</h3>
 * <ul>
 * <li>{@link frontend.com.google_voltpatches.common.collect.ImmutableTable}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ArrayTable}
 * <li>{@link frontend.com.google_voltpatches.common.collect.HashBasedTable}
 * <li>{@link frontend.com.google_voltpatches.common.collect.TreeBasedTable}
 * </ul>
 *
 * <h3>of {@link frontend.com.google_voltpatches.common.collect.ClassToInstanceMap}</h3>
 * <ul>
 * <li>{@link frontend.com.google_voltpatches.common.collect.ImmutableClassToInstanceMap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.MutableClassToInstanceMap}
 * </ul>
 *
 * <h2>Classes of static utility methods</h2>
 *
 * <ul>
 * <li>{@link frontend.com.google_voltpatches.common.collect.Collections2}
 * <li>{@link frontend.com.google_voltpatches.common.collect.Iterators}
 * <li>{@link frontend.com.google_voltpatches.common.collect.Iterables}
 * <li>{@link frontend.com.google_voltpatches.common.collect.Lists}
 * <li>{@link frontend.com.google_voltpatches.common.collect.Maps}
 * <li>{@link frontend.com.google_voltpatches.common.collect.Queues}
 * <li>{@link frontend.com.google_voltpatches.common.collect.Sets}
 * <li>{@link frontend.com.google_voltpatches.common.collect.Multisets}
 * <li>{@link frontend.com.google_voltpatches.common.collect.Multimaps}
 * <li>{@link frontend.com.google_voltpatches.common.collect.Tables}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ObjectArrays}
 * </ul>
 *
 * <h2>Comparison</h2>
 *
 * <ul>
 * <li>{@link frontend.com.google_voltpatches.common.collect.Ordering}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ComparisonChain}
 * </ul>
 *
 * <h2>Abstract implementations</h2>
 *
 * <ul>
 * <li>{@link frontend.com.google_voltpatches.common.collect.AbstractIterator}
 * <li>{@link frontend.com.google_voltpatches.common.collect.AbstractSequentialIterator}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ImmutableCollection}
 * <li>{@link frontend.com.google_voltpatches.common.collect.UnmodifiableIterator}
 * <li>{@link frontend.com.google_voltpatches.common.collect.UnmodifiableListIterator}
 * </ul>
 *
 * <h2>Ranges</h2>
 *
 * <ul>
 * <li>{@link frontend.com.google_voltpatches.common.collect.Range}
 * <li>{@link frontend.com.google_voltpatches.common.collect.RangeMap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.DiscreteDomain}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ContiguousSet}
 * </ul>
 *
 * <h2>Other</h2>
 *
 * <ul>
 * <li>{@link frontend.com.google_voltpatches.common.collect.Interner},
 *     {@link frontend.com.google_voltpatches.common.collect.Interners}
 * <li>{@link frontend.com.google_voltpatches.common.collect.Constraint},
 *     {@link frontend.com.google_voltpatches.common.collect.Constraints}
 * <li>{@link frontend.com.google_voltpatches.common.collect.MapConstraint},
 *     {@link frontend.com.google_voltpatches.common.collect.MapConstraints}
 * <li>{@link frontend.com.google_voltpatches.common.collect.MapDifference},
 *     {@link frontend.com.google_voltpatches.common.collect.SortedMapDifference}
 * <li>{@link frontend.com.google_voltpatches.common.collect.MinMaxPriorityQueue}
 * <li>{@link frontend.com.google_voltpatches.common.collect.PeekingIterator}
 * </ul>
 *
 * <h2>Forwarding collections</h2>
 *
 * <ul>
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingCollection}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingConcurrentMap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingIterator}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingList}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingListIterator}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingListMultimap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingMap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingMapEntry}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingMultimap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingMultiset}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingNavigableMap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingNavigableSet}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingObject}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingQueue}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingSet}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingSetMultimap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingSortedMap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingSortedMultiset}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingSortedSet}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingSortedSetMultimap}
 * <li>{@link frontend.com.google_voltpatches.common.collect.ForwardingTable}
 * </ul>
 */
@frontend.javax.annotation_voltpatches.ParametersAreNonnullByDefault
package frontend.com.google_voltpatches.common.collect;
